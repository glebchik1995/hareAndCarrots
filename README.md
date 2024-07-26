## Задача: Заяц и морковь

**Описание задачи:**

Есть 5 полянок. На каждой полянке огород с морковкой. На каждой полянке растет морковь различного веса. Зайцу необходимо за 10 ходок унести максимальное количество моркови с полянок за 1 день, причем заяц за одну ходку может нести только 5 кг моркови. Необходимо составить эффективный алгоритм, который самостоятельно должен найти решение на Java.

**Алгоритм:**

Программа использует жадный алгоритм для решения задачи. Алгоритм работает следующим образом:

**Инициализация:**

* Создается массив `carrotBeds`, хранящий вес моркови на каждой полянке.
* Определяется максимальная грузоподъемность зайца (`maxCarryingCapacity`) и количество ходок (`numberOfWalkers`).

**Сбор моркови за все ходки (`collectCarrots`):**

1. В цикле по количеству ходок (`numberOfWalkers`) вызывается метод `collectCarrotsOnTrip` для имитации сбора моркови за одну ходку.
2. Сумма моркови, собранной за каждую ходку, сохраняется в переменной `totalCarrots`.

**Сбор моркови за одну ходку (`collectCarrotsOnTrip`):**

1. Заяц начинает с самой тяжелой полянки (j = `carrotBeds.length - 1`).
2. В цикле заяц проверяет, может ли он унести всю морковь с текущей полянки.
3. Если да, то он забирает ее (`collectedCarrots += carrotBeds[j]`) и уменьшает оставшуюся грузоподъемность (`remainingCapacity`). После этого морковь с полянки удаляется (`carrotBeds[j] = 0`).
4. Если заяц не может унести всю морковь, он забирает столько, сколько может (`collectedCarrots += remainingCapacity`), уменьшает вес моркови на полянке (`carrotBeds[i] -= remainingCapacity`) и обнуляет оставшуюся грузоподъемность (`remainingCapacity = 0`).
5. Заяц переходит к следующей полянке, пока не заполнит свой "рюкзак" (`remainingCapacity > 0`) или не обойдет все полянки.

**Результат:**

После завершения всех ходок (`numberOfWalkers`) программа выводит общее количество унесенной моркови (`totalCarrots`).

**Преимущества алгоритма:**

* **Жадный подход:** Заяц всегда стремится унести как можно больше моркови на каждой ходке, не задумываясь о будущем.
* **Эффективность:** В этом конкретном случае алгоритм жадного выбора оказывается оптимальным, так как заяц всегда будет стремиться унести как можно больше моркови на каждой ходке.