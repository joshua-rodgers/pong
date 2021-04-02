@ECHO off 
del bin\com\joshuarodgers\*.class
javac src\com\joshuarodgers\*.java -d bin
cd bin 
java com.joshuarodgers.Pong
cd ..