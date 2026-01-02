#!/bin/bash

# Répertoire source des vidéos
src_dir="/Users/mac/Documents/Cours_ETNA/TIC-YOUTUBE/myYoutubeV2/Api/backend/output"

# Répertoire de sortie pour les vidéos converties
out_dir="/Users/mac/Documents/Cours_ETNA/TIC-YOUTUBE/myYoutubeV2/Api/backend/upload-dir"

# Boucle sur tous les fichiers mp4 dans le répertoire source
for file in "$src_dir"/*.mp4; do
  # Récupération du nom de fichier sans l'extension
  filename=$(basename "$file" .mp4)

  # récupération de la résolution de la vidéo
  resolution=$(ffmpeg -i "$file" 2>&1 | grep -oP '(?<=Video: ).*(?=, bitrate)')

  # vérification si la résolution contient la largeur et la hauteur
  if [[ $resolution =~ [0-9]+x[0-9]+ ]]; then
    # Conversion de la vidéo en 1080p
    ffmpeg -i "$file" -c:v libx264 -b:v 3000k -c:a aac -b:a 128k -s 1920x1080 -q:v 0 -q:a 0 "$out_dir/$filename-1080p.mp4"

    # Conversion de la vidéo en 720p
    ffmpeg -i "$file" -c:v libx264 -b:v 2000k -c:a aac -b:a 128k -s 1280x720 -q:v 0 -q:a 0 "$out_dir/$filename-720p.mp4"

    # Conversion de la vidéo en 480p
    ffmpeg -i "$file" -c:v libx264 -b:v 1000k -c:a aac -b:a 128k -s 854x480 -q:v 0 -q:a 0 "$out_dir/$filename-480p.mp4"

    # Conversion de la vidéo en 360p
    ffmpeg -i "$file" -c:v libx264 -b:v 800k -c:a aac -b:a 128k -s 640x360 -q:v 0 -q:a 0 "$out_dir/$filename-360p.mp4"

    # Conversion de la vidéo en 240p
    ffmpeg -i "$file" -c:v libx264 -b:v 400k -c:a aac -b:a 128k -s 426x240 -q:v 0 -q:a 0 "$out_dir/$filename-240p.mp4"
  else
    echo "La résolution de la vidéo $file n'est pas valide."
  fi

  # vérifier si le fichier est déjà converti
  if [ -f "$out_dir/$filename-1080p.mp4" ] && [ -f "$out_dir/$filename-720p.mp4" ] && [ -f "$out_dir/$filename-480p.mp4" ] && [ -f "$out_dir/$filename-360p.mp4" ] && [ - -f "$out_dir/$filename-240p.mp4" ]; then
echo "La vidéo $filename a déjà été convertie."
else
echo "Conversion de la vidéo $filename en cours..."
# Conversion de la vidéo en 1080p
ffmpeg -i "$file" -c:v libx264 -b:v 3000k -c:a aac -b:a 128k -s 1920x1080 -q:v 0 -q:a 0 "$out_dir/$filename-1080p.mp4"
# Conversion de la vidéo en 720p
ffmpeg -i "$file" -c:v libx264 -b:v 2000k -c:a aac -b:a 128k -s 1280x720 -q:v 0 -q:a 0 "$out_dir/$filename-720p.mp4"

# Conversion de la vidéo en 480p
ffmpeg -i "$file" -c:v libx264 -b:v 1000k -c:a aac -b:a 128k -s 854x480 -q:v 0 -q:a 0 "$out_dir/$filename-480p.mp4"

# Conversion de la vidéo en 360p
ffmpeg -i "$file" -c:v libx264 -b:v 800k -c:a aac -b:a 128k -s 640x360 -q:v 0 -q:a 0 "$out_dir/$filename-360p.mp4"

# Conversion de la vidéo en 240p
ffmpeg -i "$file" -c:v libx264 -b:v 400k -c:a aac -b:a 128k -s 426x240 -q:v 0 -q:a 0 "$out_dir/$filename-240p.mp4"

echo "La vidéo $filename a été convertie avec succès."

fi
done

echo "Toutes les vidéos ont été traitées."

