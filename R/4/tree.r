library(rpart)
model <- rpart(Species ~ Sepal.Length + Sepal.Width + Petal.Length + Petal.Width, method="class", data=iris)
summary(model) 
#post(model, file = "./tree.ps", title = "Classification Tree for iris")
post(model, title = "Classification Tree for iris")





# # grow tree 
# fit <- rpart(Kyphosis ~ Age + Number + Start, method="class", data=kyphosis)

# printcp(fit) 
# plotcp(fit) 
# summary(fit) 

# # plot tree 
# plot(fit, uniform=TRUE, main="Classification Tree for Kyphosis")
# text(fit, use.n=TRUE, all=TRUE, cex=.8)

# create attractive postscript plot of tree 
#post(fit, file = "c:/tree.ps", title = "Classification Tree for Kyphosis")




# grow tree 

#printcp(fit) 
#plotcp(fit) 

# plot tree 
#plot(fit, uniform=TRUE, main="Classification Tree for Kyphosis")
#text(fit, use.n=TRUE, all=TRUE, cex=.8)

# create attractive postscript plot of tree 
