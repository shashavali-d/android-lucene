Android Lucene: A Lucene port for mobile
================================================

Lucene is a Java full-text search engine and this is an experimental port of Lucene 8.4. The aim is to make Lucene run on
Android thus adding or enabling search capabilities to the applications.

This project uses Gradle build and deployed as JAR, below is a high-level overview.


Build Instructions
------------------

To build this project JAR, use the below commands:

```bash
./gradlew build clean
./gradlew build
```

Before executing the above commands make sure `JAVA_HOME`, `JAVA_HOME/bin` and `JAVA_HOME/lib` paths are added to the Environment variables. The above commands would generate the JAR in `lucene-8.4.0/build/libs` folder.

Currently, the original Lucene tests are removed from this project. 


Porting Lucene to Android
-------------------------

Lucene 8.4.0 has many packages and the ones which are essential to search/index for mobile are moved to `lucene-core` package and the remaining ones are deleted from actual [lucene-solr](https://github.com/apache/lucene-solr/tree/master/lucene) repo 


Ported Packages
---------------

* lucene-analysis
* lucene-core
* lucene-highlighter
* lucene-join
* lucene-memory
* lucene-store
* lucene-queries
* lucene-queryparser
* lucene-sandbox
* lucene-suggest

