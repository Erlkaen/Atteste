FROM node:8.11.2-alpine as builder

WORKDIR /app

COPY . .

RUN npm install
RUN npm run build --prod

FROM nginx:alpine
COPY --from=builder /app/dist/* /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
