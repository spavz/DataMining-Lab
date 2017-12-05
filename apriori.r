#install.packages("arules", repos ="http://cran.stat.ucla.edu/")
#install.packages("arulesViz", repos ="http://cran.stat.ucla.edu/")

library(arules)

data = read.transactions("ItemList.csv", sep=",",cols=1);
rules = apriori(data, parameter = list(sup = 0.01, conf = 0.01));
inspect(rules)

#library(arulesViz)

#plot(rules)






#install.packages("~/Downloads/arules_1.5-4.tar.gz", dependencies=TRUE, repos= NULL, type = "source")

