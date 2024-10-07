import sbt.*
import sbt.Keys.*

/**
  * Automatically enriches projects with the following settings (despite the word "override").
  */
object ProjectPlugin extends AutoPlugin {

  /**
    * Defines what members will be imported to the `build.sbt` scope.
    */
  val autoImport = ThingsToAutoImport

  /**
    * Thus plug-in will automatically be enabled; it has no requirements.
    */
  override def trigger: PluginTrigger = AllRequirements

  object ThingsToAutoImport {
    private def jarName(s: String) =
      "pom2sbt-" + s

    def module(s: String): Project =
      Project(s, file(jarName(s)))
        .settings(name := jarName(s))
  }
}
