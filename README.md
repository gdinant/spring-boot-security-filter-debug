# spring-boot-security-filter-debug

Run the application

Service will run on port 9003 by default.

curl http://localhost:9003/secured-api (403)
curl http://localhost:9003/public/open-api (200 OK)

MyFilter is supposed to be called only once for /secured-api, but isn't.

```java
2023-01-04T11:34:28.456+01:00  INFO 64283 --- [           main] com.kao.spring.DemoApplication           : Starting DemoApplication using Java 17.0.4.1 with PID 64283 (/Users/Gabriel.Dinant/Documents/repositories/private/ecowaste/spring-boot-security-filter-debug/target/classes started by Gabriel.Dinant in /Users/Gabriel.Dinant/Documents/repositories/private/ecowaste)
2023-01-04T11:34:28.459+01:00  INFO 64283 --- [           main] com.kao.spring.DemoApplication           : No active profile set, falling back to 1 default profile: "default"
2023-01-04T11:34:28.915+01:00  INFO 64283 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 9003 (http)
2023-01-04T11:34:28.919+01:00  INFO 64283 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-01-04T11:34:28.919+01:00  INFO 64283 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.4]
2023-01-04T11:34:28.958+01:00  INFO 64283 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-01-04T11:34:28.959+01:00  INFO 64283 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 470 ms
2023-01-04T11:34:29.053+01:00  INFO 64283 --- [           main] o.s.s.web.DefaultSecurityFilterChain     : Will secure any request with [org.springframework.security.web.session.DisableEncodeUrlFilter@43b5021c, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@28369db0, org.springframework.security.web.context.SecurityContextHolderFilter@6cd98a05, org.springframework.security.web.header.HeaderWriterFilter@27be17c8, org.springframework.security.web.csrf.CsrfFilter@5034f5dd, org.springframework.security.web.authentication.logout.LogoutFilter@42cc183e, com.kao.spring.controller.ComponentSecurityContext$MyFilter@30893e08, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@1e95b653, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@31120021, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@2e86807a, org.springframework.security.web.access.ExceptionTranslationFilter@6d8796c1, org.springframework.security.web.access.intercept.AuthorizationFilter@61514735]
2023-01-04T11:34:29.192+01:00  INFO 64283 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 9003 (http) with context path ''
2023-01-04T11:34:29.197+01:00  INFO 64283 --- [           main] com.kao.spring.DemoApplication           : Started DemoApplication in 0.933 seconds (process running for 1.293)
2023-01-04T11:34:35.256+01:00  INFO 64283 --- [nio-9003-exec-2] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
2023-01-04T11:34:35.256+01:00  INFO 64283 --- [nio-9003-exec-2] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
2023-01-04T11:34:35.257+01:00  INFO 64283 --- [nio-9003-exec-2] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
Filter is called for uri: /public/open-api
Filter is called for uri: /secured-api
```
