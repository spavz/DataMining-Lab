#install.packages('e1071', dependencies = TRUE)
# library(class) 
library(e1071) 
pairs(iris[1:4], main = "Iris Data (red=setosa,green=versicolor,blue=virginica)",pch = 21, bg = c("red", "green", "blue")[unclass(iris$Species)])
model <-naiveBayes(iris[,1:4], iris[,5]) 
table(predict(model, iris[,-5]), iris[,5])