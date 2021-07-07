import com.chandler.feign.client.example.groovy.IRoute

class groovyRoute implements IRoute {

    @Override
    String route(String serviceId) {
        return "hello:"+serviceId
    }

    @Override
    String routeList(String serviceId,List<String> nodes) {
        int len=0
        for (node in nodes) {
            len += node.length()
        }
        return "hello:"+serviceId + len
    }
}