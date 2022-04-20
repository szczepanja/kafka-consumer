# kafka-consumer

How to run this

- zookeeper:

````
    C:\kafka\bin\windows>zookeeper-server-start.bat C:kafka\config\zookeeper.properties
````

- kafka server:

````
    C:\kafka\bin\windows>kafka-server-start.bat C:\kafka\config\server.properties
````

- read message from consumer:

 ````
  C:\kafka\bin\windows>kafka-console-consumer.bat --topic <topic-name> --from-beginning --bootstrap-server :9092
````

- read message from producer:

 ````
  C:\kafka\bin\windows>kafka-console-producer.bat --topic <topic-name> --bootstrap-server :9092
````