import jenkins.model.*
import hudson.model.*
import javaposse.jobdsl.plugin.*

def instance = Jenkins.instance

def jobName = "seed"
def job = instance.getItem(jobName)

if (job == null) {
    println "--> Création du job ${jobName}"

    def seedJob = instance.createProject(FreeStyleProject, jobName)
    
    def dslScript = new ExecuteDslScripts()
    dslScript.targets = "jobs/pipeline/*.groovy" //"/var/jenkins_home/jobs/pipeline/*.groovy"
    dslScript.usingScriptText = false
    dslScript.ignoreExisting = false
    dslScript.removedJobAction = RemovedJobAction.IGNORE
    dslScript.removedViewAction = RemovedViewAction.IGNORE
    dslScript.lookupStrategy = LookupStrategy.JENKINS_ROOT
    dslScript.additionalClasspath = ""

    seedJob.buildersList.add(dslScript)
    seedJob.save()

    println "--> Job ${jobName} créé avec DSL, prêt à être lancé manuellement."
} else {
    println "--> Job ${jobName} existe déjà"
}