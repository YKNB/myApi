# Nom de votre image Docker
IMAGE_NAME=video-converter

# Variables pour les répertoires source et de sortie
SRC_DIR=/Users/mac/Documents/Cours_ETNA/TIC-YOUTUBE/myYoutubeV2/Api/backend/output
OUT_DIR=/Users/mac/Documents/Cours_ETNA/TIC-YOUTUBE/myYoutubeV2/Api/backend/upload-dir

# Construction de l'image Docker à partir de votre Dockerfile
build:
	docker build -t $(IMAGE_NAME) .

# Lancement de votre conteneur à partir de l'image construite
run:
	docker run -v $(SRC_DIR):/src -v $(OUT_DIR):/out $(IMAGE_NAME)

# Suppression de l'image Docker existante
clean:
	docker rmi $(IMAGE_NAME)

# Automatisation de la conversion avec crontab
cron:
	docker exec -it $(IMAGE_NAME) bash -c "echo '*/5 * * * * /usr/local/bin/convert.sh' >> /etc/crontab"
