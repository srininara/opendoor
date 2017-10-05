package org.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class ExecWait extends DefaultTask {
    String[] commandLine
    String ready
    String workingDir


    @TaskAction
    def spawnProcess() {
        ProcessBuilder builder = new ProcessBuilder(commandLine)
        builder.directory(new File(workingDir))
        builder.redirectErrorStream(true)
        Process process = builder.start();
        InputStream stdout = process.getInputStream()
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(stdout))

        def line
        while ((line = reader.readLine()) != null) {
            println line
            if (line.contains(ready)) {
                println "$commandLine is ready"
                break;
            }
        }
    }
}