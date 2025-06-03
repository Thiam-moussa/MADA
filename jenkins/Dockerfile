FROM jenkins/jenkins:lts

USER root

# Installer dépendances utiles + Docker CLI
RUN apt-get update && \
    apt-get install -y \
    git \
    curl \
    unzip \
    docker.io && \
    rm -rf /var/lib/apt/lists/*

# Ajouter Jenkins au groupe docker (utile si tu veux lancer Docker depuis Jenkins)
RUN usermod -aG docker jenkins

# Revenir à l'utilisateur Jenkins
USER jenkins

# Copier les plugins et les installer
COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

# Ajouter les scripts init et les jobs à préconfigurer
COPY init.groovy.d/ /usr/share/jenkins/ref/init.groovy.d/
COPY jobs/ /usr/share/jenkins/ref/jobs/
