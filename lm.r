x <- c(151, 174, 138, 186, 128, 136, 179, 163, 152, 131)
y <- c(63, 81, 56, 91, 47, 57, 76, 72, 62, 48)
model <- lm(y~x)
plot(y, x, main = "Regression", abline(lm(x~y)))



# print(summary(model))

a <- data.frame(x = 170)
result <-  predict(model,a)
print(result)




# plot(y, x, main = "Regression", abline(lm(x~y)), cex = 1.3, xlab = "Weight in Kg", ylab = "Height in cm")
