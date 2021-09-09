job('first_node_example') {
    // Description
    description('This is my first job using DSL.')

    // parameters for this appliaction
    parameters {
        stringParam('Planet', defaultValue = 'world', description = 'This is a description of Planet')
        booleanParam('FLAG', true)
        choiceParam('OPTION', ['option 1 (default)', 'option 2', 'option 3'])
    }

    // source code manager
    scm {
        git('https://github.com/Daniely2564/docker-nodejs-app.git', 'main') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@newtech.academy')
        }
    }

    triggers {
        cron('H 5 * * 7')
    }

    steps {
        shell('npm install')
    }
}
