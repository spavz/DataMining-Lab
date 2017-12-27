library(ggplot2)
ggplot(iris, aes(Petal.Length, Petal.Width, color = Species)) + geom_point()
model <- kmeans(iris[, 3:4], 3, nstart = 20)
model
table(model$cluster, iris$Species)
model$cluster <- as.factor(model$cluster)
ggplot(iris, aes(Petal.Length, Petal.Width, color = model$cluster)) + geom_point()