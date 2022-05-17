FROM node:alpine
WORKDIR app
RUN npm install -g @angular/cli
COPY . .
CMD ["ng", "serve", "--host", "0.0.0.0"]
