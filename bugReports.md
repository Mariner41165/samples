**Bug report title 1:** [Events] FE : Спортсмена невозможно добавить в разные категории

**Precondition:** Войти в систему как администратор национальной федерации: email admin@mail.ru, password Aa1111

**Priority:** Critical

**Steps to reproduce:** 
1. Перейти в раздел Events
2. Выбрать соревнование "TeamCompetition" (дата: 1 марта), нажать кнопку "Event's details"
3. Открыть раздел "Application for Event"
4. В категории Sport SAMBO - Adults (Women's) нажать "+ Weight category / Athletes"
5. В поле "Weight category -50kg" добавить спортсмена Marina Delbeeva, нажать кнопку Save
6. В категории Combat SAMBO - Adults (Women's) нажать "+ Weight category / Athletes"
7. В поле "Weight category -50kg" добавить спортсмена Marina Delbeeva, нажать кнопку Save

**Expected result:** спортсмен успешно добавлен в две дисциплины

**Actual result:** на странице присутствует ошибка при попытке сохранить спортсмена во второй категории (Combat sambo), спортсмена добавить не удается, возможность обойти баг отсутствует


**Bug report title 2:** [Events] BE : 500-я ошибка при создании заявки на командные соревнования

**Precondition:** Войти в систему как администратор национальной федерации: email admin@mail.ru, password Aa1111

**Priority:** Critical

**Steps to reproduce:**
1. Перейти в раздел Events
2. Выбрать соревнование "Qwerty" (дата: 26 февраля), нажать кнопку "Event's details"
3. На странице нажать кнопку "Apply for event"

**Expected result:** заявка успешно формируется, на странице присутствует уведомление Application for competition was successfully created

**Actual result:** сервер отдает ошибку: "Http failure response for https://.../applications: 500 OK", подать заявку невозможно, баг воспроизводится при любом мероприятии в категории командные соревнования
