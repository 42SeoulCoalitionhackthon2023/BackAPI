git add -A
git stash
git pull
./gradlew build
java -jar build/libs/evaluation-0.0.1-SNAPSHOT.jar
