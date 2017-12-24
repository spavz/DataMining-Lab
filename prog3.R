data <- read.csv("data.csv",header = TRUE)
print(data)
write.csv(data,"/home/kiran/data_senml.csv",quote = T,append = F,row.names = T,col.names = T)
