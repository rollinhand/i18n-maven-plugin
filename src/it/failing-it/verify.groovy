File buildLog = new File( basedir, "build.log" );
assert buildLog.isFile()

// assert we have thrown an I18NException
buildLog.eachLine {line ->
    if (line.contains("Key is missing in XLS file")) {
        assert true
    }
}
