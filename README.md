# SendingErrorLogViaEmail

# In Kotlin
1)  var libaryStoreData = LibaryStoreData(this)
2)  libaryStoreData?.saveLibaryRequiredData("senderEmail@gmail.com", "senderPassword", "receiverEmail")
eg:-
            try {
            
                throw RuntimeException("RuntimeException Error")
                
            } catch (e: Exception) {
            
                SendingErrorLog(e,this,false)
                
            }
            
# In Java
1)  LibaryStoreData  libaryStoreData = new LibaryStoreData(this);
2)  libaryStoreData.saveLibaryRequiredData("senderEmail@gmail.com", "senderPassword", "receiverEmail");
eg:-          
             try {
             
                 throw new RuntimeException("RuntimeException Error");
                 
               } catch (Exception e) {
               
                  SendingErrorLog(e, this, false);
                  
               }
      
         
       
