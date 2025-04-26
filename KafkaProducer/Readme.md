# Kafka
## Kurulum
* compose klasorü icindeki docker-compose.yml dosyasını calistiriniz.
  * bu dosya bir bitnami/kafka container'ı oluştaracaktır.
  * container oluşturma aşamasında container iciden logs diyerek. logları izleyebilirsiniz.

## Producer
* bu uygulamanın swagger adresinden yeni bir topic oluşturulması gerekiyor.
  * **topic bilgileri**
    * name: vereceğiniz isim
    * partition: kac partition olacagi.
    * replication: kac yedeği olacagi. 1 veya -1 giriniz
* bu topic'e send-kafka end point ile veri gönderebilirsiniz.


## Terminalden Mesaj okumak icin (Consumer)
* docker icindeki kafka terminaline bağlanmamız gerekiyor.  
`docker exec -it <dosyaAdi>-<continaerAdi> sh`  
`docker exec -it compose-kafka-1 sh`


* terminale bağlantıkdan sonra hangi topic'i dinleyeceğimizi belirtmeliyiz.  
`kafka-console-consumer.sh --bootstrap-server <ip:port> --topic <topicAdi> --from-beginning`  
`kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic yenikargo --from-beginning`


* dinlemeyi sonlandırmak icin: terminal icinde  
`ctrl+c`


* kafka terminalinden cikmak icin: terminal icinde  
`exit`