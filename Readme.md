# Elephant Bird JsonLoader #

This is purely a derivative of Elephant Bird. If you want the original and complete version that speaks thrift, proto buffer and has lots of functionality, you should checkout [the real Elephant Bird](https://github.com/kevinweil/elephant-bird)

Based on Elephant Bird Version: 1.2.2

#### Twitter's library of [LZO](http://www.github.com/kevinweil/hadoop-lzo), [Thrift](http://thrift.apache.org/), and/or [Protocol Buffer](http://code.google.com/p/protobuf)-related [Hadoop](http://hadoop.apache.org) InputFormats, OutputFormats, Writables, [Pig](http://pig.apache.org/) LoadFuncs, [Hive](http://hadoop.apache.org/hive) SerDe, [HBase](http://hadoop.apache.org/hbase) miscellanea, etc. The majority of these are in production at Twitter running over data every day. ####

Stripped down to just a single PigJsonLoader that is compatible with pig 0.8.

### To Use ###

1. git clone
2. ant
3. check out javadoc, etc.

Start your pig-script with:
    REGISTER lib/google-collect.jar;
    REGISTER lib/json-simple.jar;
    REGISTER lib/elephant-bird.jar;
    REGISTER lib/slf4j-log4j12-1.5.10.jar;
    REGISTER lib/slf4j-api-1.5.10.jar;
    REGISTER lib/log4j-1.2.15.jar;

    json = LOAD 'filename' USING com.twitter.elephantbird.pig.load.PigJsonLoader();

### Version compatibility ###

1. Pig 0.8

### License ###

Apache licensed.

### Contents ###

##### Hadoop Input Formats #####
* JSON data

    
### Commit Back! ###

Bug fixes, features, and documentation improvements are welcome!  Please fork and send me a pull request on github, and I will do my best to keep up.  If you make major changes, add yourself to the contributors list below.

### Contributors ###

* Kevin Weil ([@kevinweil](http://twitter.com/kevinweil))
* Dmitriy Ryaboy ([@squarecog](http://twitter.com/squarecog))
* Chuang Liu ([@chuangl4](http://twitter.com/chuangl4))
* Florian Liebert ([@floliebert](http://twitter.com/floliebert))
* Ning Liang ([@ningliang](http://twitter.com/ningliang))
* Johan Oskarsson ([@skr](http://twitter.com/skr))
* Raghu Angadi ([@raghuangadi](http://twitter.com/raghuangadi))
* Kim Vogt ([@kimsterv](http://twitter.com/kimsterv))
* Knut O. Hellan ([@knuthellan](http://twitter.com/knuthellan))
