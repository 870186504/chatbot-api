# 基础镜像
FROM openjdk:8-jre-slim
# 作者
MAINTAINER pengziyi
# 配置
ENV PARAMS=""
# 时区
ENV TZ=PRC
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#ENV JAVA_OPTS = "-Xms256m -Xmx256m"
# 添加应用
ADD /chatbot-api-interfaces/target/chatbot-api.jar /chatbot-api.jar
#docker run -e PARAMS= "--chatbot-api.groupId=28885855552551 --chatbot-api.openAiKey=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 --chatbot-api.cookie=zsxq_access_token=3E882423-78A9-9E64-3991-9102BC8B9B0A_D493C3B91AAF0386; zsxqsessionid=b078fc24d9df6c02431eeb8f78cad8d1; abtest_env=product; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22841542812544852%22%2C%22first_id%22%3A%221861fda3e9552a-071948b0fcd6ea-16525635-1930176-1861fda3e961578%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMTg2MWZkYTNlOTU1MmEtMDcxOTQ4YjBmY2Q2ZWEtMTY1MjU2MzUtMTkzMDE3Ni0xODYxZmRhM2U5NjE1NzgiLCIkaWRlbnRpdHlfbG9naW5faWQiOiI4NDE1NDI4MTI1NDQ4NTIifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22841542812544852%22%7D%2C%22%24device_id%22%3A%221861fda3e9552a-071948b0fcd6ea-16525635-1930176-1861fda3e961578%22%7D; UM_distinctid=186201c6694e4f-079f3b4d74934c-16525635-1d73c0-186201c66951413" -p 8090:8090 --name chatbot-api -d chatbot-api:1.0/
# 执行镜像；docker run -e PARAMS=" --chatbot-api.groupId=你的星球ID --chatbot-api.openAiKey=自行申请 --chatbot-api.cookie=登录cookie信息" -p 8090:8090 --name chatbot-api -d chatbot-api:1.0
ENTRYPOINT ["sh","-c","java -jar  /chatbot-api.jar $PARAMS"]
