How is a request handled?

For example,
1.A user tries to visit this URL: http://localhost:7890/spring_sample/Collector.

2.The servelet(whose type is DispatcherServlet) will see this request and it'll try to find all the handler mappings.

3.FlowHandlerMapping will be found because it matches "/spring_sample/Collector".

-------above this line: spring mvc-------below this line: web flow----------

4.When a valid flow mapping is found, the FlowHandlerAdapter figures out whether to start a new execution of that flow
or resume an existing execution based on information present the HTTP request.
In this case, a new flow will be started, because this is the first request to the flow "Collector".

5.Then it goes to the flowRegistry, which knows all the flows under the folder "/WEB-INF/Pages" that match the pattern "/**/*-flow.xml".
And "Collector-flow.xml" is found.

6.The flowRegistry can find flows, but it does not know how to interpret a flow, so it goes to the flowBuilderServices.

7.The flowBuilderServices customizes the services and settings used to build flows in a flow-registry, in this particular case, it knows
the viewResolver through the viewFactoryCreator, so all the jsp pages under "/WEB-INF/Pages/" can be discovered.
And the flow-builder-services uses a parser to parse the EL language expressions.

8.Then the viewResolver will find "NamePage.jsp" and the first view of the flow will finally be built and returned to the client.



Tips:
*The MvcViewFactoryCreator is the factory that allows you to configure how the Spring MVC view system is used inside Spring Web Flow.
 Use it to configure existing ViewResolvers.
*Spring EL is the default and recommended expression language to use.
However it is possible to replace it with Unified EL if you wish to do so.
You need the following Spring configuration to plug in the WebFlowELExpressionParser to the flow-builder-services:
        <webflow:flow-builder-services expression-parser="expressionParser"/>
        <bean id="expressionParser" class="org.springframework.webflow.expression.el.WebFl
            <constructor-arg>
                <bean class="org.jboss.el.ExpressionFactoryImpl" />
            </constructor-arg>
</bean>

Doubt: when does the executor kick in?