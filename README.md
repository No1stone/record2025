### spring ai exame

로컬 올라마 모델을 이용한
deepseek, EXAONE 2개모델을 운용하는 백엔드 프로젝트

ref= https://docs.spring.io/spring-ai/reference/api/chat/ollama-chat.html

spring git: https://github.com/spring-projects/spring-ai/tree/main/models/spring-ai-ollama

![img.png](src/main/resources/static/img.png)

![img_1.png](src/main/resources/static/img_1.png)

![img_2.png](src/main/resources/static/img_2.png)

![img_3.png](src/main/resources/static/img_3.png)

chatgpt
ref = https://platform.openai.com/settings/organization/billing/overview

gemini 
ref = https://aistudio.google.com/apikey

```bash
curl "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=GEMINI_API_KEY" \
-H 'Content-Type: application/json' \
-X POST \
-d '{
  "contents": [{
    "parts":[{"text": "Explain how AI works"}]
    }]
   }'
```

![img_4.png](src/main/resources/static/img_4.png)

api활성
![img_5.png](src/main/resources/static/img_5.png)

![img_6.png](src/main/resources/static/img_6.png)


