# Elephant Bird PigJsonLoader #

### PigJsonLoader ###

Stripped down to just the JsonLoader and made compatible with pig 0.8

### Version 1.2.2 ###

NO TICKET. Protobuf Pig storage : don't reuse builder object.

### Version 1.2.1 ###

ISSUE 28. Equals is now consistent with CompareTo for ProtobufWritables (rangadi)

ISSUE 30.  Handle Boolean and Bytes in ProtobufStorage, and add generators. (rangadi) 

ISSUE 30.  Handle Thrift binary and double types in ThriftToPig schema (rangadi)

ISSUE 30.  Deprecated Json Input format and Thrift byte to Tuple UDF (rangadi)

NO TICKET. Add JsonLoader (without LZO) and JsonStringToMap UDF (dvryaboy)

ISSUE 28. Make ProtobufWritable have stable hashCode() implementation (dvryaboy)
