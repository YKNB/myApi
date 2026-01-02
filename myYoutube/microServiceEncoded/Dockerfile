# Utilisation de l'image Ubuntu comme base
FROM ubuntu:20.04

# Installation de FFmpeg et crontab
RUN apt-get update && \
    apt-get install -y ffmpeg cron

# Copie de votre script de conversion dans le conteneur
COPY convert.sh /usr/local/bin/convert.sh

# Autorisation de l'exécution de votre script
RUN chmod +x /usr/local/bin/convert.sh

# Définition des variables d'environnement pour les répertoires source et de sortie
ENV SRC_DIR=/Users/mac/Documents/Cours_ETNA/TIC-YOUTUBE/myYoutubeV2/Api/backend/output/
ENV OUT_DIR=/Users/mac/Documents/Cours_ETNA/TIC-YOUTUBE/myYoutubeV2/Api/backend/upload-dir/


# Activation de crontab
RUN touch /var/log/cron.log

# Lancement de votre script de conversion à chaque démarrage du conteneur
CMD ["cron", "-f"]
