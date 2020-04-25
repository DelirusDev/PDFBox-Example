#Creating PDFs with Java

1. Clone repository

```
git clone https://github.com/DelirusDev/PDFBox-Example.git
```

2. Build package

```
mvn package
```

3. Create PDF with/without an image

```
java -cp target\uber-pdfbox-example-1.0-SNAPSHOT.jar delirus.dev.App NielsBohr.jpg
java -cp target\uber-pdfbox-example-1.0-SNAPSHOT.jar delirus.dev.App
```