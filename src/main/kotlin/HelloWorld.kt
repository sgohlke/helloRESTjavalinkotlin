import io.javalin.Javalin
import java.lang.Exception
import java.time.LocalDateTime

fun main(args: Array<String>) {
    val app = Javalin.create().start(7000)
    app.get("/") { ctx -> ctx.result("Hello REST " + LocalDateTime.now()) }
            .get("/person") { ctx -> ctx.result("List of available Persons " + PersonStorage.personList.toString()) }
            .get("/person/:index") { ctx ->
                val personIndex = ctx.pathParam("index").toIntOrNull()
                ctx.json(if (personIndex == null) Person("UNKNOWN", "UNKNOWN", 999) else PersonStorage.personList.get(ctx.pathParam("index").toInt()))
            }
            .post("/graphql") { ctx ->
                val queryResult: String
                try {
                    queryResult = PersonStorage.personSchema.execute(ctx.body())
                    ctx.result(queryResult).contentType("application/json")
                } catch (e: Exception) {
                    e.printStackTrace()
                    ctx.json("An error occurred " + e.message)
                }
            }
}