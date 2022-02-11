MarkdownParse.class: MarkdownParse.java
	javac MarkdownParse.java

MarkdownParseTester.class: MarkdownParseTester.java
	javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java

test: MarkdownParse.class MarkdownParseTester.class
	java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest
	
