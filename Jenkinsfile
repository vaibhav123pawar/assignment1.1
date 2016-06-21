#!groovy

//1
stage 'clone_AssignmentProject'
node {
git 'https://github.com/BitwiseInc/assignment1.1.git'
}

//2
stage 'build_AssignmentProject'
node{
  if(isUnix()){
  sh 'gradle build --info'
    
  }
  else{
    bat 'gradle build --info'
  }
}

//3
stage 'Publish-Artifact'
node{
   if(isUnix()){
    sh 'gradle publish --info'
  }
  else{
   bat 'gradle publish --info'
}
}
//4
stage 'Sonar-report'
node{
     if(isUnix()){
          sh 'gradle sonarqube --info'
     }else{
          bat 'gradle sonarqube --info'
     }
}

//5
stage 'JaCoCo-Coverage-report'
node{
     if(isUnix()){
          sh 'gradle jacoco --info'
     }else{
          bat 'gradle jacoco --info'
     }
}

//8
//stage 'send-mail'
//node{
  //   mail bcc: 'priyanka.dhoble@bitwiseglobal.com', body: 'Please check out the jenkins file build', cc: 'priyanka.dhoble@bitwiseglobal.com', charset: 'UTF-8', from: '', mimeType: 'text/plain', replyTo: '', subject: 'JENKINS-FILE build', to: 'priyanka.dhoble@bitwiseglobal.com'
//}
