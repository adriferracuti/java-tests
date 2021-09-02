package com.adri.protobuf;

import com.adri.proto.ProtoMyStringV2;
import com.adri.proto.ProtoMyStringV3;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProtoV2V3StringConversionTest {

    @Test
    @DisplayName("Given a proto v2 string field," +
            "when created from byte array then the Java type is LiteralByteString," +
            "when created from json then the Java type is String")
    public void testV2TypesFromJsonAndByteArrayParsing()
            throws InvalidProtocolBufferException, NoSuchFieldException, IllegalAccessException {

        var byteArray = ProtoMyStringV2.newBuilder().setFoo("bar").build().toByteArray();
        var protoFromByteArray = ProtoMyStringV2.newBuilder().mergeFrom(byteArray).build();

        final String json = "{\"foo\": \"bar\"}";
        var fromJsonBuilder = ProtoMyStringV2.newBuilder();
        JsonFormat.parser().merge(json, fromJsonBuilder);
        var protoFromJson = fromJsonBuilder.build();

        var fooField = ProtoMyStringV2.class.getDeclaredField("foo_");
        fooField.setAccessible(true);

        assertEquals(
                "class com.google.protobuf.ByteString$LiteralByteString",
                fooField.get(protoFromByteArray).getClass().toString());

        assertEquals(String.class, fooField.get(protoFromJson).getClass());
    }

    @Test
    @DisplayName("Given a proto v3 string field," +
            "when created from byte array then the Java type is String," +
            "when created from json then the Java type is String")
    public void testV3TypesFromJsonAndByteArrayParsing()
            throws InvalidProtocolBufferException, NoSuchFieldException, IllegalAccessException {

        var byteArray = ProtoMyStringV3.newBuilder().setFoo("bar").build().toByteArray();
        var protoFromByteArray = ProtoMyStringV3.newBuilder().mergeFrom(byteArray).build();

        final String json = "{\"foo\": \"bar\"}";
        var fromJsonBuilder = ProtoMyStringV3.newBuilder();
        JsonFormat.parser().merge(json, fromJsonBuilder);
        var protoFromJson = fromJsonBuilder.build();

        var fooField = ProtoMyStringV3.class.getDeclaredField("foo_");
        fooField.setAccessible(true);

        assertEquals(String.class, fooField.get(protoFromByteArray).getClass());
        assertEquals(String.class, fooField.get(protoFromJson).getClass());
    }
}
