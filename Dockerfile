# Use the official AdoptOpenJDK base image with Java 17
FROM my-local-java17

# Set the working directory inside the container
WORKDIR /app


# Copy only the build.gradle and settings.gradle files to leverage Docker layer caching
#COPY build.gradle settings.gradle /app/

# Copy the entire project (excluding build artifacts and dependencies) to leverage Docker layer caching
#COPY src /app/src

# Download and install Gradle
#RUN curl -s "https://get.sdkman.io" | bash
#RUN /bin/bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install gradle"

# Build the application
#RUN /bin/bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && gradle build"



# Copy the JAR file into the container at /app
COPY build/libs/kafkaDemoMicronaut-0.1-all.jar /app/myjarname.jar

# Expose the port that your Micronaut application is running on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "myjarname.jar"]
