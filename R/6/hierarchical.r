library(ggplot2)

clusters <- hclust(dist(iris[, 3:4]), method="average")
plot(clusters)
cut <- cutree(clusters, 3)
table(cut, iris$Species)
ggplot(iris, aes(Petal.Length, Petal.Width, color = iris$Species)) + geom_point(col = cut)
