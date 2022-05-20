FROM node:16-alpine as build
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

FROM node:16-alpine as runtime
WORKDIR /app
RUN npm install -g serve
COPY --from=build /app/dist .
EXPOSE 3000
CMD ["serve", "-s", "."]
