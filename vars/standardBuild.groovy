def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()
    node {
        stage('checkout') {
            checkout scm
        }
        stage('main') {
            docker.image(config.environment).inside {
                sh config.mainScript
            }
        }
        stage('post') {
            sh config.postScript
        }
    }
}
