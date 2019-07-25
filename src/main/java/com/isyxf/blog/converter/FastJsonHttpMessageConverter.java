package com.isyxf.blog.converter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.isyxf.blog.dto.Result;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Y.Jer
 * 使用 fasterJson 过滤null字段
 */
public class FastJsonHttpMessageConverter implements HttpMessageConverter<Object> {
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    private final static Logger logger = LoggerFactory.getLogger(FastJsonHttpMessageConverter.class);
    private List<MediaType> supportedMediaTypes = Arrays.asList(MediaType.APPLICATION_JSON);
    private boolean writeAcceptCharset = true;

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        if (mediaType == null) {
            return true;
        }

        for (MediaType supportedMediaType : getSupportedMediaTypes()) {
            if (supportedMediaType.includes(mediaType)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        if (mediaType == null || MediaType.ALL.equals(mediaType)) {
            return true;
        }

        for (MediaType supportedMediaType : getSupportedMediaTypes()) {
            if (supportedMediaType.includes(mediaType)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return supportedMediaTypes;
    }

    @Override
    public Object read(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        if (clazz != null) {
            Charset charset = getContentTypeCharset(inputMessage.getHeaders().getContentType());
            String body = IOUtils.toString(inputMessage.getBody(), charset);
            if (StringUtils.isNotBlank(body)) {
                return JSON.parseObject(body, clazz);
            } else {
                try {
                    return clazz.newInstance();
                } catch (Exception e) {
                    logger.error("failed@clazz.newInstance", e);
                    return null;
                }
            }
        } else {
            return null;
        }
    }

    @Override
    public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        if (this.writeAcceptCharset) {
            outputMessage.getHeaders().setAcceptCharset(Arrays.asList(DEFAULT_CHARSET));
        }
        outputMessage.getHeaders().set("Content-Type", "application/json;charset=UTF-8");

        Charset charset = getContentTypeCharset(outputMessage.getHeaders().getContentType());

        if (o instanceof Result){
            Result result = (Result) o;
            JSONObject json = new JSONObject();
            json.put("code", result.getCode());
            if (StringUtils.isNotBlank(result.getMessage())){
                json.put("message", result.getMessage());
            }
            if (null != result.getResult()){
                json.put("data", result.getResult());
            }

            String feature = outputMessage.getHeaders().getFirst("SERIALIZE_FEATURE");
            List<SerializerFeature> featureList = new ArrayList<>();
            if (StringUtils.isNotBlank(feature)){
                int flag = Integer.parseInt(feature);
                if (SerializeFeature.hasFeature(flag, SerializeFeature.WRITE_NULL_MAP_VALUE)){
                    featureList.add(SerializerFeature.WriteMapNullValue);
                }
            }
            IOUtils.write(JSON.toJSONString(o, featureList.toArray(new SerializerFeature[0])), outputMessage.getBody(), charset);
        } else {
            IOUtils.write(JSON.toJSONString(o), outputMessage.getBody(), charset);
        }
    }

    private Charset getContentTypeCharset(MediaType contentType) {
        if ((contentType != null) && (contentType.getCharset() != null)) {
            return contentType.getCharset();
        }
        return DEFAULT_CHARSET;
    }
}
