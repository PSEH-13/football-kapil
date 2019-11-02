pipeline{
agent any
stages{
stage('compile'){
steps{
sh "./mvnw clean compile"
}
}
stage('test'){
steps{
sh "./mvnw test"
}
}
stage('package'){
steps{
sh "./mvnw clean package	"
}
}

}
}