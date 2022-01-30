# RomajiToHiraganaConversion
ローマ字をひらがなに変換するJava/Scala用ライブラリ

# 依存関係

sbt
---
```sbt
resolvers += "Maven Repo on github" at "https://rito528.github.io/"
libraryDependencies += "RomajiToHiraganaConvertion" % "romajitohiraganaconvertion_2.13" % "1.0.0"
```


maven
---

```xml
    <repositories>
        <repository>
            <id>github</id>
            <name>rito528-github-repo</name>
            <url>https://rito528.github.io/</url>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>RomajiToHiraganaConvertion</groupId>
            <artifactId>romajitohiraganaconvertion_2.13</artifactId>
            <version>1.0.0</version>
        </dependency>
    </dependencies>
```
