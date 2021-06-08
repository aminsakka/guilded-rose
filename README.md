# Le kata Gilded Rose 

Dans le kata Gilded Rose, le code est rendu obscur par une complexité cyclomatique importance (beaucoup de chemins possibles), 
et les tests se distinguent par leur absence. Toute ressemblance avec du code réellement en production serait bien évidemment 
purement fortuite.

Intéressons nous maintenant au problème posé par Gilded Rose (trouvable sur le Github d'Emily Bache : https://github.com/emilybache/GildedRose-Refactoring-Kata).
Une description bien détaillé http://iamnotmyself.com/2011/02/14/refactor-this-the-gilded-rose-kata/

On nous parle d’une petite auberge dans une cité prospère, qui propose des articles à la vente. Seulement, leur qualité se dégrade au 
fur et à mesure que leur date limite de vente approche. Pour se faciliter la gestion d’inventaire, l’aubergiste, Allison, 
a demandé à Leeroy, un aventurier, de développer une application pour ça.

Ce dernier étant parti pour de nouvelles aventures, elle nous demande d’intervenir pour supporter une nouvelle catégorie d’articles (de type “Conjured”), 
dont la qualité se dégrade deux fois plus rapidement que d’ordinaire.

Chaque article est caractérisé par un **nom**, une **qualité** qui indique sa valeur intrinsèque, et une **date limite** désignant le nombre de jours avant lequel 
l’article doit être vendu.

Pretty simple, right? Well this is where it gets interesting. Here is some business rules :

- Once the sell by date has passed, Quality degrades twice as fast
- The Quality of an item is never negative
- “Aged Brie” actually increases in Quality the older it gets
- The Quality of an item is never more than 50
- “Sulfuras”, being a legendary item, never has to be sold or decreases in Quality
- “Backstage passes”, like aged brie, increases in Quality as it’s SellIn value approaches; Quality increases by 2 when there are 10 days or less 
and by 3 when there are 5 days or less but Quality drops to 0 after the concert
