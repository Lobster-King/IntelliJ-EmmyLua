package com.tang.intellij.lua.stubs.index;

import com.intellij.openapi.project.Project;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.stubs.StringStubIndexExtension;
import com.intellij.psi.stubs.StubIndexKey;
import com.tang.intellij.lua.comment.psi.LuaDocFieldDef;
import com.tang.intellij.lua.lang.LuaLanguage;
import com.tang.intellij.lua.psi.LuaClassField;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

/**
 *
 * Created by tangzx on 2016/12/10.
 */
public class LuaClassFieldIndex extends StringStubIndexExtension<LuaClassField> {

    public static final StubIndexKey<String, LuaClassField> KEY = StubIndexKey.createIndexKey("lua.index.class.field");

    private static final LuaClassFieldIndex INSTANCE = new LuaClassFieldIndex();

    public static LuaClassFieldIndex getInstance() {
        return INSTANCE;
    }

    @Override
    public int getVersion() { return LuaLanguage.INDEX_VERSION;}

    @NotNull
    @Override
    public StubIndexKey<String, LuaClassField> getKey() {
        return KEY;
    }

    public static LuaClassField find(String key, Project project, GlobalSearchScope scope) {
        Collection<LuaClassField> list = INSTANCE.get(key, project, scope);
        if (!list.isEmpty())
            return list.iterator().next();
        return null;
    }

    public static LuaClassField find(String className, String fieldName, Project project, GlobalSearchScope scope) {
        return find(className + "." + fieldName, project, scope);
    }
}
