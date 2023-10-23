package dev.ja.test

import com.intellij.openapi.application.invokeLater
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity
import com.intellij.openapi.startup.StartupManager
import com.intellij.openapi.ui.Messages

class JavaStartupActivity : ProjectActivity {
    override suspend fun execute(project: Project) {
        StartupManager.getInstance(project).runAfterOpened {
            invokeLater {
                Messages.showInfoMessage("Optional Java dependency was loaded.", "Test Plugin")
            }
        }
    }
}
