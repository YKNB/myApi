# myApi
Projet d'APIs et microservices pour un service de streaming video.

## Contenu

### apiRestful
API REST Spring Boot avec authentification JWT, gestion des utilisateurs, videos,
posts et commentaires. La configuration par defaut (profil dev) utilise MySQL
et stocke les fichiers sur disque.
- Code: `apiRestful/`
- Documentation: `apiRestful/documentation/API3 _ myAPI.pdf`

### myYoutube
Ensemble de microservices autour de l'API (front Vue, recherche, encodage, mail).
- Code: `myYoutube/`
- Schema: `myYoutube/documentation/schema.png`
- Documentation: `myYoutube/documentation/TIC-API3 _ myYouTube.pdf`

## Execution rapide

### apiRestful (Spring Boot + Maven)
Prerequis: JDK 11+ et MySQL en local.

1) Lancer MySQL avec une base `test` et les identifiants `root` / `password`
   (voir `apiRestful/src/main/resources/application-dev.properties`).
2) Demarrer l'API:

```bash
cd apiRestful
./mvnw spring-boot:run
# Windows: mvnw.cmd spring-boot:run
```

Note: `apiRestful/docker-compose.yml` demarre un PostgreSQL. Si vous utilisez
PostgreSQL, adaptez les proprietes `spring.datasource.*`.

### myYoutube (microservices)

#### Frontend Vue
```bash
cd myYoutube/microService-Vue
npm install
npm run serve
```

#### API principale (Spring Boot + Gradle)
Le backend est dans `myYoutube/Api/backend`. Un `docker-compose.yml` est fourni
pour MySQL, mais il attend un fichier `.env` avec les variables suivantes:
`MYSQLDB_ROOT_PASSWORD`, `MYSQLDB_DATABASE`, `MYSQLDB_LOCAL_PORT`,
`MYSQLDB_DOCKER_PORT`, `MYSQLDB_USER`, `SPRING_LOCAL_PORT`,
`SPRING_DOCKER_PORT`.

```bash
cd myYoutube/Api/backend
./gradlew bootRun
# Windows: gradlew.bat bootRun
```

#### Moteur de recherche (Spring Boot)
```bash
cd myYoutube/microService-moteurRecherche
./gradlew bootRun
```

#### Moteur de recherche Elasticsearch (Spring Boot)
- Requiert Elasticsearch 7.12.0.
- Mettre a jour `myYoutube/microService-moteurRechercheElasticSearch/src/main/resources/application.properties`
  (DB MySQL, chemins `file.upload-dir` et `ffmpeg.path`).

```bash
cd myYoutube/microService-moteurRechercheElasticSearch
./gradlew bootRun
```
Le service ecoute par defaut sur le port 8090.

#### Encodage video (FFmpeg)
Microservice Docker dans `myYoutube/microServiceEncoded/`.
Les chemins dans `convert.sh` et `makefile` sont absolus et doivent etre adaptes.

```bash
cd myYoutube/microServiceEncoded
make build
make run
```

#### Mail (Maildev)
```bash
cd myYoutube/MicroService-Mail/maildev
docker compose up -d
```
Interface web: http://localhost:8080, SMTP: localhost:8025.
