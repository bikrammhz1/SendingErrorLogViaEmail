# SendingErrorLogViaEmail

How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.bikrammhz1:SendingErrorLogViaEmail:1.1'
	}
            
# In Kotlin
1)  var libaryStoreData = LibaryStoreData(this)
2)  libaryStoreData?.saveLibaryRequiredData("senderEmail@gmail.com", "senderPassword", "receiverEmail")

eg:-

            try {
            
                throw RuntimeException("RuntimeException Error")
                
            } catch (e: Exception) {
            
                SendingErrorLog(e,this,false,false)
                
            }
            
# In Java
1)  LibaryStoreData  libaryStoreData = new LibaryStoreData(this);
2)  libaryStoreData.saveLibaryRequiredData("senderEmail@gmail.com", "senderPassword", "receiverEmail");

eg:-      

             try {
             
                 throw new RuntimeException("RuntimeException Error");
                 
               } catch (Exception e) {
               
                  SendingErrorLog(e, this, false,true);
                  
               }
      
         
       
