pipelineJob('pipeline') {
    definition {
        cps {
            script("""
                pipeline {
                    agent any
                    stages {
                        stage('Hello') {
                            steps {
                                echo 'Coucou depuis le pipeline DSL !'
                            }
                        }
                    }
                }
            """.stripIndent())
            sandbox()
        }
    }
}
