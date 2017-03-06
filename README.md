#Captcha Service
This is the lightweight captcha service,It has some implements,also you can extend yourself!

+  ChallengeProvider 

ChallengeProvider - Define a riddle and result generate algorithm.    
RandomChallengeProvider - Random code [0-9a-z],for the challenge riddle equal result.  
CalculatingChallengeProvider  - Define a simle expression riddle and it's result.

+  StoreProvider  

StoreProvider  - Define where the result to store.  
CacheStoreProvider - Local cache.     
RedisStoreProvider - Redis.  

+  CaptchaService  

CaptchaService - Define the type of captcha and how to use it.  
GenericCaptchaService - An abstract implement,you can extend it and must inject ChallengeProvider and StoreProvider.  
ImageCaptchaService -  An image captcha service.If injected different ChallengeProvider or StoreProvider,will show different functions.