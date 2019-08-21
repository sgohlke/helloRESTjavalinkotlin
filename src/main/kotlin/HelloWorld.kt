import io.javalin.Javalin
import java.time.LocalDateTime

fun main(args: Array<String>) {
    val app = Javalin.create().start(7000)
    app.get("/") { ctx -> ctx.result("Hello REST "  + LocalDateTime.now()) }
}